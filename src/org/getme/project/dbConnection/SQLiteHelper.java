package org.getme.project.dbConnection;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.getme.project.model.UserModel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "GetMeDatabase.db";
	private SQLiteDatabase database;
	
	//For user_table
	public static final String USER_TABLE_NAME = "USER_TABLE";
	public static final String COLUMN_USER_ID = "UID";
	public static final String COLUMN_FIRST_NAME = "FIRSTNAME";
	public static final String COLUMN_LAST_NAME = "LASTNAME";
	public static final String COLUMN_USERNAME = "USERNAME";
	public static final String COLUMN_EMAIL = "EMAIL";
	public static final String COLUMN_PASSWORD = "PASSWORD";
	public static final String COLUMN_REGISTER_DATE = "REGISTERDATE";
	
	//For sender_receiver_table
	public static final String SENDER_RECIEVER_TABLE_NAME = "SENDER_RECIEVER_TABLE";
	public static final String COLUMN_SR_ID = "SRID";
	public static final String COLUMN_SENDER_USERNAME = "SENDERUSERNAME";
	public static final String COLUMN_RECEIVER_USERNAME = "RECEIVERUSERNAME";
	public static final String COLUMN_SENDER_LATITUDE = "SENDERLATITUDE";
	public static final String COLUMN_SENDER_LONGITUDE = "SENDERLONGITUDE";
	public static final String COLUMN_SENDER_TITLE = "SENDERTITLE";
	public static final String COLUMN_SENDER_DESCRIPTION = "SENDERDESCRIPTION";
	public static final String COLUMN_SEND_DATE = "SENDDATE";
	
	public SQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		
		//For user_table
		db.execSQL("create table " + USER_TABLE_NAME + " ( "  
				+ COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," 
				+ COLUMN_FIRST_NAME + " VARCHAR, " 
				+ COLUMN_LAST_NAME + " VARCHAR, "
				+ COLUMN_USERNAME + " VARCHAR, "
				+ COLUMN_EMAIL + " VARCHAR, "
				+ COLUMN_PASSWORD + " VARCHAR, "
				+ COLUMN_REGISTER_DATE + " DATETIME);");
		
		//For sender_receiver_table
		db.execSQL("create table " + SENDER_RECIEVER_TABLE_NAME + " ( "  
				+ COLUMN_SR_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," 
				+ COLUMN_SENDER_USERNAME + " VARCHAR, " 
				+ COLUMN_RECEIVER_USERNAME + " VARCHAR, "
				+ COLUMN_SENDER_LATITUDE + " INTEGER, "
				+ COLUMN_SENDER_LONGITUDE + " INTEGER, "
				+ COLUMN_SENDER_TITLE + " VARCHAR, "
				+ COLUMN_SENDER_DESCRIPTION + " VARCHAR, "
				+ COLUMN_SEND_DATE + " DATETIME);");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE_NAME);
		db.execSQL("DROP TABLE IF EXISTS " + SENDER_RECIEVER_TABLE_NAME);
		onCreate(db);
	}
	
	public void insertUserRecord(UserModel user) {
		database = this.getReadableDatabase();
		ContentValues content = new ContentValues();
		content.put(COLUMN_FIRST_NAME, user.getFirstName());
		content.put(COLUMN_LAST_NAME, user.getLastName());
		content.put(COLUMN_USERNAME, user.getUserName());
		content.put(COLUMN_EMAIL, user.getEmail());
		content.put(COLUMN_PASSWORD, user.getPassword());
		content.put(COLUMN_REGISTER_DATE, user.getDate().toString());
		database.insert(USER_TABLE_NAME, null, content);
		database.close();
	}
	
	public void updateUserRecord(UserModel user) {
		database = this.getReadableDatabase();
		ContentValues content = new ContentValues();
		content.put(COLUMN_FIRST_NAME, user.getFirstName());
		content.put(COLUMN_LAST_NAME, user.getLastName());
		content.put(COLUMN_USERNAME, user.getUserName());
		content.put(COLUMN_EMAIL, user.getEmail());
		content.put(COLUMN_PASSWORD, user.getPassword());
		content.put(COLUMN_REGISTER_DATE, user.getDate().toString());
		database.update(USER_TABLE_NAME, content, COLUMN_USER_ID + " = ?", new String[]{user.getUid()});
		database.close();
	}
	
	public void deleteRecord(UserModel user) {
		database = this.getReadableDatabase();
		database.delete(USER_TABLE_NAME, COLUMN_USER_ID + " = ?", new String[]{user.getUid()});
		database.close();
	}
	
	public ArrayList<UserModel> getAllRecords() {
		database = this.getReadableDatabase();
		Cursor cursor = database.query(USER_TABLE_NAME, null, null, null, null, null, null);
		ArrayList<UserModel> contacts = new ArrayList<UserModel>();
		UserModel userModel;
		if (cursor.getCount() > 0) {
			for (int i = 0; i < cursor.getCount(); i++) {
				cursor.moveToNext();
				userModel = new UserModel();
				userModel.setUid(cursor.getString(0));
				userModel.setFirstName(cursor.getString(1));
				userModel.setLastName(cursor.getString(2));
				userModel.setUserName(cursor.getString(3));
				userModel.setEmail(cursor.getString(4));
				userModel.setPassword(cursor.getString(5));
				String date = cursor.getString(6);
				DateFormat dateParse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date regDate = null;
				try {
					regDate = (Date) dateParse.parse(date);
				}
				catch (Exception e) {}
				userModel.setDate(regDate);				
				contacts.add(userModel);
			}
		}
		cursor.close();
		database.close();
		return contacts;
	}
}
