package HelpTodo.helptodoBackend.service;

import HelpTodo.helptodoBackend.domain.Member;
import HelpTodo.helptodoBackend.domain.Team;
import HelpTodo.helptodoBackend.repository.TeamRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    @Transactional
    public String createTeam(Team team) {
        validateDuplicateTeam(team);
        validateEmpty(team);
        //TODO : 회원이 로그인한 상태인지 검증 추가하기

        teamRepository.save(team);

        return team.getName();
    }

    public Team findTeamByName(String name){

        List<Team> findTeams = teamRepository.findByName(name);
        Team team = findTeams.get(0);

        return team;
    }


    private void validateEmpty(Team team) {
        if(team.getName() == null){
            throw new IllegalStateException("팀 이름 공백");
        }
    }

    private void validateDuplicateTeam(Team team) {
        List<Team> findTeams = teamRepository.findByName(team.getName());
        if (!findTeams.isEmpty()) {
            throw new IllegalStateException("중복 회원");
        }
    }
}
