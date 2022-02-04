package mj.guri.service;

import org.springframework.beans.factory.annotation.Autowired;

import mj.guri.dao.QnaDAO;
import mj.guri.vo.QnaRegiVO;

public class QnaRegiService {
	@Autowired
	private QnaDAO qnadao;
	
	public void regist(QnaRegiVO qVo, int memberNum) {
		qnadao.insertQna(qVo, memberNum);
	}

}
