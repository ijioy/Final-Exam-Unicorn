USE Unicorn;

SELECT * FROM Student

CREATE PROCEDURE MostPopularMajor
	@Year AS INT
AS
BEGIN
	SELECT 
		maj.[Name] AS [Nama Jurusan],
		COUNT(stu.StudentNumber)
	FROM dbo.Student AS stu
		JOIN dbo.StudentMajor AS sm ON stu.StudentNumber=sm.StudentNumber
		JOIN dbo.Major AS maj ON sm.MajorID=maj.ID
	WHERE YEAR(stu.RegisterDate)=@Year
	GROUP BY maj.[Name]
END
EXECUTE dbo.MostPopularMajor @Year = '2013';