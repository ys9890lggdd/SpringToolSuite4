package com.tistory.offbyone.service;

import java.util.List;

public interface SawonDAO {
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
	 */
	SawonVO selectSawon(String sabun);

	/**
	 * 포상 정보를 조회한다.
	 * @param sabun
	 * @return
	 * @throws Exception
	 */
	List<PrizeVO> selectPrizeList(String sabun) throws Exception;

	/**
	 * 사원 정보를 입력한다.
	 * @param sawon
	 * @throws Exception
	 */
	void insertSawon(SawonVO sawon) throws Exception;

	/**
	 * 포상 정보를 입력한다.
	 * @param prize
	 * @throws Exception
	 */
	void insertPrize(PrizeVO prize) throws Exception;

	/**
	 * 상을 삭제한다.
	 * @param sabun
	 * @throws Exception
	 */
	void deletePrize(String sabun) throws Exception;

	/**
	 * 사원을 삭제한다.
	 * @param sabun
	 * @throws Exception
	 */
	void deleteSawon(String sabun) throws Exception;

	/**
	 * 사원을 업데이트한다.
	 * @param sawon
	 * @throws Exception
	 */
	void updateSawon(SawonVO sawon) throws Exception;
}
