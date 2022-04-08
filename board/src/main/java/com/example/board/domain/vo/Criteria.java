package com.example.board.domain.vo;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@RequiredArgsConstructor
public class Criteria {
//   생성자로 초기화 시 pageNum과 amount만 초기화하기 위해서 @NonNull을 붙인다.
    @NonNull
    private int pageNum;
    @NonNull
    private int amount;
    private String type;
    private String keyword;

//   롬복을 통해 생성된 초기화 생성자를 기본 생성자에서 기본 값을 설정한 뒤 호출해준다.
    public Criteria(){this(1,10);}



}
