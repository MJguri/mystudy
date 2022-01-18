package spring.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import spring.vo.Member;

public class MemberDao {// DB 대신 Map을 사용해 봅니다.
	
	private static long nextId = 0;  // 시퀀스
	
	private Map<String, Member> map = new HashMap<>(); //사실상 DB
	
	// 회원가입을 위한 insert
	public void insert(Member member) {
		member.setId(++nextId);
		map.put(member.getEmail(), member);
	//"hong@naver.com":[hong@naver.com , 1234, 홍길동]
	}
	
	// 회원 정보를 조회하기 위한 select
	public Member selectByEmail(String email) {
		return map.get(email);
	}
	
	// 회원 정보 변경을 위한 update
	public void update(Member member) {
		map.put(member.getEmail(), member);
	}
	
	// 가입된 전체 회원을 알기 위한 selectAll
	public Collection<Member> selectAll(){
		return map.values();
	}

}
