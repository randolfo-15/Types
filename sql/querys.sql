INSERT INTO Categories (_name,_brief,_color) VALUES (?,?,?);
UPDATE Categories SET _name=?,_brief=?,_color=? WHERE _name = ?;
DELETE FROM Categories WHERE _name= ?;
SELECT _name,_brief,_color FROM Categories WHERE _name = ?; 
INSERT INTO Kinds (_name,_name_ctg,_icon,_exemple,_size,_extension) VALUES (?,?,?,?,?,?,?);
UPDATE Kinds SET _name=?,_name_ctg=?,_icon=?,_exemple=?,_size=?,_extension WHERE _name=?;
DELETE FROM Kinds WHERE _name= ?;
SELECT _name,_name_ctg,_icon,_exemple,_size,_extension FROM Kinds WHERE _name = ?;