package com.chapadinhos.api.mapper;

import com.chapadinhos.api.request.RoundRequest;
import com.chapadinhos.api.response.RoundResponse;
import com.chapadinhos.domain.entity.Round;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RoundMapper {

    private final ModelMapper mapper;

    public Round toRound(RoundRequest request) {
        return mapper.map(request, Round.class);
    }

    public RoundResponse toRoundResponse(Round round) {
        return mapper.map(round, RoundResponse.class);
    }

    public List<RoundResponse> toRoundResponseList(List<Round> rounds) {
        return rounds.stream()
                .map(this::toRoundResponse)
                .collect(Collectors.toList());
    }

}
