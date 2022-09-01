package com.its.caffebeans.service;

import com.its.caffebeans.dto.BoardDTO;
import com.its.caffebeans.entiry.BoardEntity;
import com.its.caffebeans.entiry.MemberEntity;
import com.its.caffebeans.repository.BoardRepository;
import com.its.caffebeans.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository;

    public Long save(BoardDTO boardDTO) throws IOException {
        MultipartFile boardFile = boardDTO.getBoardFile();
        String boardFileName = boardFile.getOriginalFilename();
        boardFileName = System.currentTimeMillis() + "_" + boardFileName;
        String savePath = "D:\\spring_boot\\" + boardFileName;
        if (!boardFile.isEmpty()) {
            boardFile.transferTo(new File(savePath));
        }
        boardDTO.setBoardFileName(boardFileName);
        Optional<MemberEntity> byMemberEmail = memberRepository.findByMemberEmail(boardDTO.getBoardWriter());
        if(byMemberEmail.isEmpty()){
         return boardRepository.save(BoardEntity.toSaveEntity(boardDTO)).getBoardId();
        }
        return null;
    }
    @Transactional
    public List<BoardDTO> findAll() {
         List<BoardEntity> all = boardRepository.findAll();
         List<BoardDTO> boardDTOList = new ArrayList<>();
         for(BoardEntity board : all){
             boardDTOList.add(BoardDTO.toBoardDTO(board));
         }return boardDTOList;
    }

    public BoardDTO findById(Long id) {
         Optional<BoardEntity> byId = boardRepository.findById(id);
         if(byId.isPresent()){
             BoardEntity board =byId.get();
           return   BoardDTO.toBoardDTO(board);
         }else {
             return null;
         }
    }

    public void update(BoardDTO boardDTO) {
        boardRepository.save(BoardEntity.toUpdateEntity(boardDTO));
    }

    public void delete(Long id) {
        boardRepository.deleteById(id);
    }
}
