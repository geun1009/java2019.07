package dao;

import java.util.List;
import dto.SawonDTO;

public interface SawonInter {
    // 입력기능
    public void addSawon(SawonDTO dto);
    // 출력
    public List<SawonDTO> getListSawon(String searchValue);
    // 수정
    // 삭제
    // 등등등....
}
