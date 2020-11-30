package me.huding.luobo.model;

import java.util.Date;
import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.plugin.activerecord.Record;

import me.huding.luobo.model.base.BaseNotice;
import me.huding.luobo.utils.DateUtils;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
public class Notice extends BaseNotice<Notice> {
	public static final Notice dao = new Notice();
	
	
	public static List<Notice> showNotices(){
		String sql = "select * from notice where visible = 1 and (start <= ? and end >= ?)";
		Date current = DateUtils.getCurrentDate();
		return dao.find(sql,current,current);
	}
	
	public static Page<Record> paginate(int pageNum, int pageSize) {
		String select = "select *";
		String suffix = "from notice";
		return Db.paginate(pageNum, pageSize, select, suffix);
	}
}