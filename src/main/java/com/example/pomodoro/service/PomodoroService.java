package com.example.pomodoro.service;

import com.example.pomodoro.model.PomodoroSession;
import com.example.pomodoro.repository.PomodoroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDateTime;

@Service
public class PomodoroService {

    @Autowired
    private PomodoroRepository pomodoroRepository;

    public PomodoroSession startSession(int totalPomodoros) {
        PomodoroSession pomodoroSession = new PomodoroSession();
        pomodoroSession.setTotalPomodoros(totalPomodoros);
        pomodoroSession.setCompletedPomodoros(0);
        pomodoroSession.setStartTime(LocalDateTime.now());
        return pomodoroRepository.save(pomodoroSession);
    }

    public PomodoroSession completePomodoro(Long pomodoroSessionId) {
        return pomodoroRepository.findById(pomodoroSessionId).map(pomodoroSession -> {
            pomodoroSession.setCompletedPomodoros(pomodoroSession.getCompletedPomodoros() + 1);
            if (pomodoroSession.getCompletedPomodoros() >= pomodoroSession.getTotalPomodoros()) {
                pomodoroSession.setEndTime(LocalDateTime.now());
            }
            return pomodoroRepository.save(pomodoroSession);
        }).orElseThrow(() -> new RuntimeException("Sessão não encontrada"));
    }

    public List<PomodoroSession> getAllSessions() {
        return pomodoroRepository.findAll();
    }
}
