package edu.utn.listenchat.service;

public interface IVoiceControl {

    void processVoiceCommands(String... voiceCommands);

    void restartListeningService();
}