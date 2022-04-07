package com.example.board.service;

import com.example.board.domain.dao.BoardDAO;
import com.example.board.domain.vo.BoardVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardDAO boardDAO;


    @Override
    public List<BoardVO> getList() {
        return boardDAO.getList();
    }

    @Override
    public void register(BoardVO boardVO) {
        boardDAO.register(boardVO);
    }

    @Override
    public boolean modify(BoardVO boardVO) {
        return boardDAO.modify(boardVO);
    }

    @Override
    public boolean remove(Long bno) {
        return boardDAO.remove(bno);
    }

    @Override
    public BoardVO get(Long bno) {
        return boardDAO.get(bno);
    }

    @Override
    public int getTotal() {
        return boardDAO.getTotal();
    }
}
