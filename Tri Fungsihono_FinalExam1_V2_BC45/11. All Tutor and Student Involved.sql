USE Unicorn;

CREATE PROCEDURE AllTutorandStudentInvolved
	@Subject AS INT,
	@Tanggal AS DATE
AS
BEGIN
	SELECT 
		CONCAT_WS(' ', stu.FirstName, stu.MiddleName, stu.LastName) AS [Nama Lengkap Siswa],
		CONCAT_WS(' ', tut.FirstName, tut.MiddleName, tut.LastName) AS [Nama Lengkap Tutor]
	FROM dbo.Student AS stu
		JOIN dbo.StudentMajor AS sm ON stu.StudentNumber=sm.StudentNumber
		JOIN dbo.Major AS maj ON sm.MajorID=maj.ID
		JOIN dbo.[Subject] AS sub ON maj.ID=sub.MajorID
		JOIN dbo.Enrollment AS enr ON stu.StudentNumber=enr.StudentNumber
		JOIN dbo.[Period] AS per ON enr.PeriodID=per.ID
		(SELECT 
		FROM db.o
		)
		JOIN dbo.Tutor AS tut ON com.StaffNumber=tut.StaffNumber

		JOIN dbo.Competency AS com ON sub.ID=com.SubjectID
		
		JOIN dbo.[Period] AS per ON com.ID=per.CompetencyID
		JOIN dbo.Enrollment AS enr ON per.ID=enr.PeriodID
		JOIN 

	
END


SELECT * FROM Subject