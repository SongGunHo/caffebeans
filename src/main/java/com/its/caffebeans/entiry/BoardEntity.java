package com.its.caffebeans.entiry;

import com.its.caffebeans.dto.BoardDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "board")
public class BoardEntity extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long boardId;
    @Column
    private String boardTitle;
    @Column
    private String boardWriter;
    @Column
    private String boardContents;
    @Column
    private String boardFileName;
    private String boardHits;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity memberEntity;
    public static BoardEntity toSaveEntity(BoardDTO boardDTO) {
        BoardEntity board = new BoardEntity();
        board.setBoardTitle(boardDTO.getBoardTitle());
        board.setBoardTitle(boardDTO.getBoardWriter());
        board.setBoardContents(board.getBoardContents());
        board.setBoardFileName(boardDTO.getBoardFileName());
        return board;
    }

    public static BoardEntity toUpdateEntity(BoardDTO boardDTO) {
        BoardEntity board = new BoardEntity();
        board.setBoardId(boardDTO.getId());
        board.setBoardTitle(boardDTO.getBoardTitle());
        board.setBoardWriter(board.getBoardWriter());
        board.setBoardFileName(board.getBoardFileName());
        return board;
    }
}
