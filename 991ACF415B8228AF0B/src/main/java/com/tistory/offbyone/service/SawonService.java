package com.tistory.offbyone.service;

import java.util.List;

public interface SawonService {
	/**
	 * 사원 목록을 조회한다.
	 * @return
	 * @throws Exception
	 */
	List<SawonVO> selectSawonList() throws Exception;
	
	/**
	 * 사원을 조회한다.
	 * @param sabun
	 * @return
	 * @throws Exception
	 */
	SawonVO selectSawon(String sabun) throws Exception;

	/**
	 * 사원 정보를 등록한다.
	 * 
	 * @param sawon
	 * @throws Exception
	 */
	void register(SawonVO sawon) throws Exception;

	/**
	 * 사원을 수정한다.
	 * @param sawon
	 * @throws Exception
	 */
	void updateSawon(SawonVO sawon) throws Exception;
	
	/**
	 * 사원을 삭제한다.
	 * @param sawonDetail
	 * @throws Exception
	 */
	void deleteSawon(SawonVO sawon) throws Exception;
}
