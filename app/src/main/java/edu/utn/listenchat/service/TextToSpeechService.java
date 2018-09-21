package edu.utn.listenchat.service;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import edu.utn.listenchat.listener.TextToSpeechCallaback;

import static android.content.ContentValues.TAG;

public class TextToSpeechService {

    private TextToSpeech textToSpeech;
    private boolean started = false;
    private List<Object[]> queue = new ArrayList<>();

    synchronized public void speak(final String message, final TextToSpeechCallaback conversionCallback, Activity appContext) {
        if (textToSpeech != null) {
            speak(message, conversionCallback);
        } else {
            textToSpeech = new TextToSpeech(appContext, new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    if (status != TextToSpeech.ERROR) {
                        textToSpeech.setLanguage(new Locale("es", "ES"));
                        textToSpeech.setPitch(1.1f);
                        textToSpeech.setSpeechRate(1f);

                        started = true;
                        TextToSpeechService.this.speak(message, conversionCallback);
                    } else {
                        conversionCallback.onErrorOccured(-1);
                    }
                }
            });
        }
    }

    private void speak(String message, TextToSpeechCallaback conversionCallback) {
        queue.add(new Object[] {message, conversionCallback});

        if (started) {
            while (!queue.isEmpty()) {
                Object[] array = queue.remove(0);
                String key = (String) array[0];
                TextToSpeechCallaback callback = (TextToSpeechCallaback) array[1];

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    ttsGreater21(message, conversionCallback);
                } else {
                    ttsUnder20(message, conversionCallback);
                }
            }
        }
    }

    @Override
    protected void finalize() throws Throwable {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.finalize();
    }

    @SuppressWarnings("deprecation")
    private void ttsUnder20(String text, final TextToSpeechCallaback textToSpeechCallaback) {
        HashMap<String, String> map = new HashMap<>();
        map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "MessageId");
 
        textToSpeech.setOnUtteranceProgressListener(new UtteranceProgressListener() {
 
            @Override 
            public void onStart(String utteranceId) {
                // TODO Auto-generated method stub 
 
            } 
 
            @Override 
            public void onError(String utteranceId) {
                // TODO Auto-generated method stub 
                Log.e(TAG, "onError: ", null);
            } 
 
            @Override 
            public void onDone(String utteranceId) {
                //do some work here 

                textToSpeechCallaback.onCompletion();
            } 
        }); 
        textToSpeech.speak(text, TextToSpeech.QUEUE_ADD, map);
    }
 
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void ttsGreater21(String text, TextToSpeechCallaback textToSpeechCallaback) {
        String utteranceId = text.hashCode() + "";
        textToSpeech.speak(text, TextToSpeech.QUEUE_ADD, null, utteranceId);
        textToSpeechCallaback.onCompletion();
    }

    public void stop() {
        textToSpeech.stop();
        queue.clear();
    }
}