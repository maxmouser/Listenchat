package edu.utn.listenchat.listener;
 
public interface TextToSpeechCallaback {
 
    void onCompletion();
 
    void onErrorOccured(int errorCode);

}