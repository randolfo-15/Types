INSERT INTO Categories (_name,_brief,_color) VALUES ('Integer','Conjunto númerico dos Inteiros','0000FF');


INSERT INTO Categories (_name,_brief,_color) VALUES ('Real','Conjunto númerico dos Racionais','00FF00');


INSERT INTO Categories (_name,_brief,_color) VALUES ('Text','Representa stream de texto','FF0000');


INSERT INTO Categories (_name,_brief,_color) VALUES ('Logic','Representa os valores lógicos true e false','FF00FF');

INSERT INTO Kinds (_name,_name_ctg,_icon,_exemple,_size,_extension) VALUES ('byte','Integer','type_byte.png','byte x=(byte) 1;',8,'MIN=-128 MAX=127');


INSERT INTO Kinds (_name,_name_ctg,_icon,_exemple,_size,_extension) VALUES ('short','Integer','type_short.png','short x=(short) 1;',16,'MIN=-32768 MAX=32767');


INSERT INTO Kinds (_name,_name_ctg,_icon,_exemple,_size,_extension) VALUES ('int','Integer','type_int.png','int x= 1;',32,'MIN=-2147483648 MAX=2147483647');


INSERT INTO Kinds (_name,_name_ctg,_icon,_exemple,_size,_extension) VALUES ('long','Integer','type_long.png','long x= 1l;',64,'MIN=-9223372036854770000 MAX=9223372036854770000');


INSERT INTO Kinds (_name,_name_ctg,_icon,_exemple,_size,_extension) VALUES ('float','Real','type_float.png','float x= 1.5f;',32,'MIN=-1.4024E-37 MAX=3.40282347E+38');


INSERT INTO Kinds (_name,_name_ctg,_icon,_exemple,_size,_extension) VALUES ('double','Real','type_double.png','double x= 1.450;',64,'MIN=-4.94E-307 MAX=1.79769313486231570E + 308');


INSERT INTO Kinds (_name,_name_ctg,_icon,_exemple,_size,_extension) VALUES ('char','Text','type_char.png','char x=''A'';',16,'MIN=0 MAX=65535');


INSERT INTO Kinds (_name,_name_ctg,_icon,_exemple,_size,_extension) VALUES ('string','Text','type_string.png','String x="abc";',64,'MIN=0 MAX=MAX=179769313486231570E + 308');


INSERT INTO Kinds (_name,_name_ctg,_icon,_exemple,_size,_extension) VALUES ('bool','Logic','type_bool.png','Boolean x=true;',1,'MIN=0 MAX=1');


