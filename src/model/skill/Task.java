package model.skill;

import java.util.Timer;
import java.util.TimerTask;

/**
 * created by Kimone
 * date 2019/3/24
 */
public class Task extends TimerTask {
    Timer timer;
    Skill skill;

    public Task(Timer timer, Skill skill) {
        this.timer = timer;
        this.skill = skill;
    }
    int i = 1;
    @Override
    public void run() {
        if(i++ == skill.getCoolingTime()){
            this.cancel();
            timer.cancel();
        }
        skill.setRemainTime(skill.remainTime-1);
        System.out.println(skill.toString());
    }
}
