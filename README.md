# SQLite_Practice

### SQL語句
##### 增

      db.execSQL("insert into info(name, phone) values(?,?)", new Object[]{"穆弘洧","0956860424"});
##### 刪
      
      db.execSQL("delete from info where name = ?", new Object[]{"穆弘洧"});
##### 改

      db.execSQL("update info set phone = ? where name = ?", new Object[]{"0988870477","穆弘洧"});
##### 查
     
     Cursor cursor = db.rawQuery("select * from info", null);
     if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String phone = cursor.getString(0);
                System.out.println(phone);
            }   
      }
 
### API
 
##### 增
 
        ContentValues values = new ContentValues();
        values.put("name", "蔡佳君");
        values.put("phone","0988870477");
        long insert = db.insert("info", null, values);
        if (insert > -1) {
            Toast.makeText(getApplicationContext(),"新增成功",Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(),"新增失敗",Toast.LENGTH_SHORT).show();
        };
##### 刪    

        int delete = db.delete("info", "name = ?", new String[]{"蔡佳君"});
        Toast.makeText(getApplicationContext(), "刪除了" + delete + "行", Toast.LENGTH_SHORT).show();
##### 改

        ContentValues values = new ContentValues();
        values.put("phone", "0956860424");
        int update = db.update("info", values, "name = ?", new String[]{"蔡佳君"});
        Toast.makeText(getApplicationContext(), "更新了" + update + "行", Toast.LENGTH_SHORT).show();
##### 查

        Cursor cursor = db.query("info", new String[]{"phone"}, "name = ?", new String[]{"蔡佳君"}, null, null, null);
        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String phone = cursor.getString(0);
                System.out.println(phone);
            }
        }  
