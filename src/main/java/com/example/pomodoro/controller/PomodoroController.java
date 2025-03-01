package com.example.pomodoro.controller;

import com.example.pomodoro.model.PomodoroSession;
import com.example.pomodoro.service.PomodoroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pomodoro")

public class PomodoroController {

    @Autowired
    private PomodoroService pomodoroService;

    @PostMapping("/start")
    public PomodoroSession startSession(@RequestParam int totalPomodoros) {
        return pomodoroService.startSession(totalPomodoros);
    }

    @PostMapping("/complete/{pomodoroSessionId}")
    public PomodoroSession completePomodoro(@PathVariable Long pomodoroSessionId) {
        return pomodoroService.completePomodoro(pomodoroSessionId);
    }


    @GetMapping("/sessions")
    public List<PomodoroSession> getAllSessions() {
        return pomodoroService.getAllSessions();
    }
}
