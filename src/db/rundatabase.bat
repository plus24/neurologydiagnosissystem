cd\
cd "Program Files"
cd MySQL
cd "MySQL Server 5.0"
cd bin

mysql -h localhost -u root -p <"D:\eclipse_workspace\ndsapp\db\createndsdb.sql"

mysql -h localhost -u root -p <"D:\eclipse_workspace\ndsapp\db\ndscasedb.sql"

mysql -h localhost -u root -p <"D:\eclipse_workspace\ndsapp\db\ndsruledb.sql"

mysql -h localhost -u root -p <"D:\eclipse_workspace\ndsapp\db\ndscases.sql"

