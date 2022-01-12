package com.mjguri.controller;

import com.mjguri.controller.action.Action;
import com.mjguri.controller.action.CurriculumListAction;
import com.mjguri.controller.action.DeleteCurriculumAction;
import com.mjguri.controller.action.InsertCurriculumAction;
import com.mjguri.controller.action.InsertCurriculumFormAction;
import com.mjguri.controller.action.LecturerListAction;
import com.mjguri.controller.action.ReadCurriculumFormAction;
import com.mjguri.controller.action.UpdateCurriculumAction;
import com.mjguri.controller.action.UpdateCurriculumFormAction;

public class ActionFactory {
	private ActionFactory() {}
	private static ActionFactory af = new ActionFactory();
	public static ActionFactory getInstance() {
		return af;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		if(command.equals("curriculum_List")) {
			action = new CurriculumListAction(); //게시물 전체 보기(목록 보기)
		}else if(command.equals("insertCurriculumForm")) {
			action = new InsertCurriculumFormAction(); //게시물 등록 폼 이동
		}else if(command.equals("insertCurriculum")) {
			action = new InsertCurriculumAction(); // 커리큘럼 등록 
		}else if(command.equals("readCurri_List")) {
			action = new ReadCurriculumFormAction();
		}else if(command.equals("deleteCurriculum")) {
			action = new DeleteCurriculumAction();
		}else if(command.equals("updateCurriculumForm")) {
			action = new UpdateCurriculumFormAction();
		}else if(command.equals("updateCurriculum")) {
			action = new UpdateCurriculumAction();
		}else if(command.equals("lecturerView")) {
			action = new LecturerListAction();
		}
		
		return action;
	}

}
