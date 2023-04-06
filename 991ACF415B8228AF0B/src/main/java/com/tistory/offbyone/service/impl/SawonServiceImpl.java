package com.tistory.offbyone.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tistory.offbyone.service.PrizeVO;
import com.tistory.offbyone.service.SawonDAO;
import com.tistory.offbyone.service.SawonService;
import com.tistory.offbyone.service.SawonVO;

@Service("sawonService")
public class SawonServiceImpl implements SawonService {
	@Autowired
	private SawonDAO sawonDao;

	/**
	 * 사원 목록을 조회한다.
	 */
	@Override
	@Transactional
	public List<SawonVO> selectSawonList() throws Exception {
		return sawonDao.selectSawonList();
	}

	/**
	 * 사원을 조회한다.
	 */
	@Override
	@Transactional
	public SawonVO selectSawon(String sabun) throws Exception {
		SawonVO sawonVO = sawonDao.selectSawon(sabun);
		sawonVO.setPrizes(sawonDao.selectPrizeList(sabun));
		return sawonVO;
	}

	/**
	 * 사원을 등록한다.
	 */
	@Override
	@Transactional
	public void register(SawonVO sawon) throws Exception {
		sawonDao.insertSawon(sawon);
		
		this.insertPrizes(sawon);
	}

	/**
	 * 사원을 삭제한다.
	 */
	@Override
	@Transactional
	public void deleteSawon(SawonVO sawon) throws Exception {
		// 상을 삭제한다.
		sawonDao.deletePrize(sawon.getSabun());
		
		// 사원을 삭제한다.
		sawonDao.deleteSawon(sawon.getSabun());
	}

	@Override
	@Transactional
	public void updateSawon(SawonVO sawon) throws Exception {
		// 사원을 업데이트한다.
		sawonDao.updateSawon(sawon);
		
		// 상을 삭제하고 다시 입력한다.
		sawonDao.deletePrize(sawon.getSabun());
		
		// 입력한다.
		this.insertPrizes(sawon);
	}
	
	/**
	 * 상을 입력한다.
	 */
	private void insertPrizes(SawonVO sawon) throws Exception {
		List<PrizeVO> prizeList = sawon.getPrizes();
		if(prizeList == null) return;
		
		int seq = 1;
		for(PrizeVO prize : prizeList) {
			if(prize.getPrizeName() == null || "".equals(prize.getPrizeName().trim())) {
				continue;
			}
			
			prize.setSabun(sawon.getSabun());
			prize.setSeq(seq++);
			sawonDao.insertPrize(prize);
		}
	}
}
