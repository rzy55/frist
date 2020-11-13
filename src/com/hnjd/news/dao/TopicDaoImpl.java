package com.hnjd.news.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hnjd.news.entity.Topic;

public class TopicDaoImpl extends BaseDao implements TopicDao {

	@Override
	public int addTopic(Topic topic) throws Exception {
		String sql="insert set topic (tname) values (?)";
		int result = excuteUpdate(sql,topic.getTname());
		return result;
	}

	@Override
	public List<Topic> allTopic() throws Exception {
		List<Topic> topicList = new ArrayList<Topic>();
		String sql="select * from topic";
		ResultSet rs = excuteQuery(sql);
		while(rs.next()) {
			Topic topic = new Topic();
			topic.setTid(rs.getInt("Tid"));
			topic.setTname(rs.getString("Tname"));
			topicList.add(topic);
		}
		return topicList;
	}

}
