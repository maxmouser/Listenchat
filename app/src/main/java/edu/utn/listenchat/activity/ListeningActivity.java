package edu.utn.listenchat.activity;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.Locale;

import edu.utn.listenchat.listener.VoiceRecognitionListener;
import edu.utn.listenchat.service.IVoiceControl;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;
import static android.speech.RecognizerIntent.EXTRA_LANGUAGE;
import static android.speech.RecognizerIntent.EXTRA_LANGUAGE_MODEL;
import static android.speech.RecognizerIntent.LANGUAGE_MODEL_FREE_FORM;
import static android.widget.Toast.LENGTH_LONG;

public abstract class ListeningActivity extends AppCompatActivity implements IVoiceControl {

    protected static final int PERMISSION_REQUEST = 9999;

    protected SpeechRecognizer speechRecognizer;

    protected void resumeListener() {
        VoiceRecognitionListener.getInstance().setListener(this); // Here we set the current listener
        startListening(); // starts listening*/
    }

    // starts the service
    private void startListening() {
        try {
            initSpeech();
            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(EXTRA_LANGUAGE, new Locale("es", "ES"));
            intent.putExtra(EXTRA_LANGUAGE_MODEL, LANGUAGE_MODEL_FREE_FORM);
            intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, this.getPackageName());
            intent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS, 15000);
            speechRecognizer.startListening(intent);
        } catch(Exception ex) {
            Log.e("SpeechRecognition", "Cannot start service", ex);
        }
    }
 
    // stops the service
    protected void stopListening() {
        if (speechRecognizer != null) {
            //speechRecognizer.stopListening();
            //speechRecognizer.cancel();
            speechRecognizer.destroy();
        }
        speechRecognizer = null;
    }
 
    protected void initSpeech() {
        if (speechRecognizer == null) {
            speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
            if (!SpeechRecognizer.isRecognitionAvailable(this)) {
                Toast.makeText(this, "Speech Recognition is not available", LENGTH_LONG).show();
                finish();
            }
            speechRecognizer.setRecognitionListener(VoiceRecognitionListener.getInstance());
        }
    }
 
    @Override
    public void finish() {
        stopListening();
        super.finish();
    }
 
    @Override
    protected void onStop() {
        stopListening();
        super.onStop();
    }

    @Override
    protected void onResume() {
        resumeListener();
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        if (speechRecognizer != null) {
            speechRecognizer.stopListening();
            speechRecognizer.cancel();
            speechRecognizer.destroy();
        }
        super.onDestroy();
    }
    
    @Override
    protected void onPause() {
        if(speechRecognizer !=null){
            speechRecognizer.stopListening();
            speechRecognizer.cancel();
            speechRecognizer.destroy();

        }
        speechRecognizer = null;

        super.onPause();
    }
    
    //is abstract so the inheriting classes need to implement it. Here you put your code which should be executed once a command was found
    @Override
    public abstract void processVoiceCommands(String ... voiceCommands);
    
    @Override
    public void restartListeningService() {
        stopListening();
        startListening();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST: {
                if (grantResults.length == 0 || grantResults[0] != PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permisos denegados. Saliendo..", LENGTH_LONG).show();
                    this.finish();
                }
                break;
            }

        }
    }
}
