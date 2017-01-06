package Dao;



import org.springframework.stereotype.Component;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import Model.DoctorModel;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

@Component
public class DoctorDao {

	// insert a doctor
	public void insertDoctor(DoctorModel doctor) {
		MongoClient mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("test");
		DBCollection coll = db.getCollection("doctors");

		BasicDBObject object = new BasicDBObject();
		object.put("id", doctor.getId());
		object.put("name", doctor.getName());
		object.put("specialisation",doctor.getSpecialisation());
		object.put("email",doctor.getEmail());
		object.put("experience",doctor.getExperience());
		object.put("contactnum",doctor.getContactnum());
		object.put("timeslot",doctor.getTimeslot());
		
		
		coll.insert(object);

	}

	// get all doctors
	public JSONArray getAllDoctors() {

		MongoClient mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("test");
		DBCollection coll = db.getCollection("doctors");

		DBCursor cursor = coll.find();

		JSONArray jsonarrray = new JSONArray();

		while (cursor.hasNext()) {
			BasicDBObject bobj = (BasicDBObject) cursor.next();
			JSONObject jobj = new JSONObject();
			jobj.put("id", bobj.get("id"));
			jobj.put("name", bobj.get("name"));
			jobj.put("specialisation", bobj.get("specialisation"));
			jobj.put("email", bobj.get("email"));
			jobj.put("experience", bobj.get("experience"));
			jobj.put("contactnum", bobj.get("contactnum"));
			jobj.put("timeslot", bobj.get("timeslot"));

			jsonarrray.add(jobj);
		}

		return jsonarrray;

	}

	// get doctor by id
	public JSONObject getDoctorById(int id) {

		MongoClient mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("test");
		DBCollection coll = db.getCollection("doctors");

		BasicDBObject bobj1 = new BasicDBObject();
		bobj1.append("id", id);

		DBCursor cursor = coll.find(bobj1);
		JSONObject jobj = new JSONObject();
		while (cursor.hasNext()) {
			BasicDBObject bobj2 = (BasicDBObject) cursor.next();
			jobj.put("id", bobj2.get("id"));
			jobj.put("name", bobj2.get("name"));
			jobj.put("specialisation", bobj2.get("specialisation"));
			jobj.put("email", bobj2.get("email"));
			jobj.put("experience", bobj2.get("experience"));
			jobj.put("contactnum", bobj2.get("contactnum"));
			jobj.put("timeslot", bobj2.get("timeslot"));

		}

		return jobj;

	}

	// update doctor by id
	public void updateDoctor(DoctorModel doctor) {
		MongoClient mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("test");
		DBCollection coll = db.getCollection("doctors");
		BasicDBObject queryobj = new BasicDBObject();
		queryobj.put("id", doctor.getId());
		DBCursor cursor = (DBCursor) coll.find(queryobj);

		while (cursor.hasNext()) {
			BasicDBObject bobj = (BasicDBObject) cursor.next();
			bobj.put("id", doctor.getId());
			bobj.put("name", doctor.getName());
			bobj.put("specialisation", doctor.getSpecialisation());
			bobj.put("email", doctor.getEmail());
			bobj.put("experience", doctor.getExperience());
			bobj.put("contactnum", doctor.getContactnum());
			bobj.put("timeslot", doctor.getTimeslot());
			coll.update(queryobj, bobj);
		}

	}
	
	//delete a doctor
	public void deleteDoctor(int id) {
		MongoClient mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("test");
		DBCollection coll = db.getCollection("doctors");
		BasicDBObject queryobj = new BasicDBObject();
		queryobj.put("id",id);
		DBCursor cursor = (DBCursor) coll.find(queryobj);

		while (cursor.hasNext()) {
			BasicDBObject bobj = (BasicDBObject) cursor.next();
			coll.remove(bobj);
		}

	}
	
	//delete all doctors
	public void deleteAllDoctor() {
		MongoClient mongoc = new MongoClient("localhost", 27017);
		DB db = mongoc.getDB("test");
		DBCollection coll = db.getCollection("doctors");
		DBCursor cursor = (DBCursor) coll.find();
		BasicDBObject bobj=new BasicDBObject();
		coll.remove(bobj);
		

	}
	
}
