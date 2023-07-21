package com.chapadinhos.api.mapper;

import com.chapadinhos.api.request.ChapadinhoRequest;
import com.chapadinhos.api.response.ChapadinhoResponse;
import com.chapadinhos.domain.entity.Chapadinho;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ChapadinhoMapper {

    private final ModelMapper mapper;

    public Chapadinho toChapadinho(ChapadinhoRequest request) {
        return mapper.map(request, Chapadinho.class);
    }

    public ChapadinhoResponse toChapadinhoResponse(Chapadinho agenda) {
        return mapper.map(agenda, ChapadinhoResponse.class);
    }

    public List<ChapadinhoResponse> toChapadinhoResponseList(List<Chapadinho> agendas) {
        return agendas.stream()
                .map(this::toChapadinhoResponse)
                .collect(Collectors.toList());
    }

}
