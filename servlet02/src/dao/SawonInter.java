package dao;

import java.util.List;
import dto.SawonDTO;

public interface SawonInter {
    // �Է±��
    public void addSawon(SawonDTO dto);
    // ���
    public List<SawonDTO> getListSawon(String searchValue);
    // ����
    // ����
    // ����....
}
