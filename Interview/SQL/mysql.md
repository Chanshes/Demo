## 数据库与MySQL
### 习题
1.数据库技术发展都经历了哪几个阶段？

    1.层次数据库和网状数据库技术阶段
    2.关系数据库技术阶段
    3.后关系数据库技术阶段

2.当前常用的流行数据库都有哪些?

    Oracle      SQL Server      DB2     MySQL       PostgreSQL

3.MySQL的数据库如何分类？

        按照早期的数据库理论，比较流行的数据库模型有三种，分别为层次式数据库、网络式数据库和关系型数据库。而当今的互联网中，最常用的数据库模型主要是两种，即关系型数据库和非关系型数据库。

4.简述数据库管理系统的基本组成。

    1.数据库
        基本结构:
            (1) 物理数据层
            (2) 概念数据层
            (3) 用户数据层

    2.数据表
        (1) 列(Columns)：也称属性列，在具体创建表时，必须指定列的名字和数据类型。
        (2) 索引(Indexes)：是指根据指定的数据库表建立起来的顺序，提供了快速访问数据的途径且可以监督表的数据，使其索引所指向的列中的数据不重复。
        (3) 触发器(Trigger)：是指用户定义的事物命令的集合，当对一个表中的数据进行插入、更新或删除时，这组命令就会自动执行，可以用来确保数据的完整性。

    3.数据库开发语言 SQL
    SQL命令
        SELECT - 从数据库中提取数据
        UPDATE - 更新数据库中的数据
        DELETE - 从数据库中删除数据
        INSERT INTO - 向数据库中插入新数据
        CREATE DATABASE - 创建新数据库
        ALTER DATABASE - 修改数据库
        CREATE TABLE - 创建新表
        ALTER TABLE - 变更（改变）数据库表
        DROP TABLE - 删除表
        CREATE INDEX - 创建索引（搜索键）
        DROP INDEX - 删除索引

    (1) SQL SELECT 语句
        SELECT 语句用于从数据库中选取数据，结果被存储在一个结果表中，称为结果集。
    SELECT column_name,column_name FROM table_name;

    (2) SQL SELECT DISTINCT 语句
        在表中，一个列可能会包含多个重复值，有时您也许希望仅仅列出不同（distinct）的值。
        DISTINCT 关键词用于返回唯一不同的值。
    SELECT DISTINCT column_name,column_name FROM table_name;

    (3)  SQL WHERE 子句
        WHERE 子句用于提取那些满足指定条件的记录。
    SELECT column_name,column_name FROM table_name WHERE column_name operator value;

    (4) SQL AND & OR 运算符
        如果第一个条件和第二个条件都成立，则 AND 运算符显示一条记录。
        如果第一个条件和第二个条件中只要有一个成立，则 OR 运算符显示一条记录。
    SELECT * FROM Websites WHERE alexa > 15 AND (country='CN' OR country='USA');

    (5) SQL ORDER BY 关键字
        ORDER BY 关键字用于对结果集按照一个列或者多个列进行排序。
        ORDER BY 关键字默认按照升序ASC对记录进行排序。如果需要按照降序对记录进行排序，您可以使用 DESC 关键字。
    SELECT column_name,column_name FROM table_name ORDER BY column_name,column_name ASC|DESC;

    (6) SQL INSERT INTO 语句
        INSERT INTO 语句用于向表中插入新记录。
        第一种形式无需指定要插入数据的列名，只需提供被插入的值即可：
    INSERT INTO table_name VALUES (value1,value2,value3,...);
        第二种形式需要指定列名及被插入的值：
    INSERT INTO table_name (column1,column2,column3,...) VALUES (value1,value2,value3,...);

    (7) SQL UPDATE 语句
        UPDATE 语句用于更新表中已存在的记录。
        UPDATE table_name
    SET column1=value1,column2=value2,... WHERE some_column=some_value;

    (8) SQL DELETE 语句
        DELETE 语句用于删除表中的行。
    DELETE FROM table_name WHERE some_column=some_value;

### 面试题
如何选择数据库？

    Oracle、DB2、SQL Server数据库主要应用于比较大的管理系统当中。Access、MySQL、PostgreSQL属于中小型数据库、主要应用与中小型的管理系统。SQL Server和Access数据库只能在Windows系列的操作系统上运行。Oracle、DB2、PostgreSQL、MySQL都可以在UNIX和Linux和Mac OS X操作系统上。Oracle和DB2都比较复杂，MySQL和PostgreSQL都非常易用，但性能不如Oracle。因此在选择数据库时，要根据运行的操作系统、项目的需求等综合考虑。