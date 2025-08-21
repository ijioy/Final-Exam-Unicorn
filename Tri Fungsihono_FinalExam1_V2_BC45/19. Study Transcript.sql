USE Unicorn;

CREATE OR ALTER PROCEDURE StudyTranscript
	@StudentNumber AS VARCHAR(30)
AS 
BEGIN
	SELECT CONCAT_WS(' ',stu.FirstName,stu.MiddleName,stu.LastName) AS [Student Fullname],
		stu.RegisterDate AS [Register Date],
		stu.TotalCreditPoint AS [Total Credit Point]
	FROM dbo.Student AS stu
	WHERE stu.StudentNumber = @StudentNumber;

	SELECT
		sub.Code AS [Subject Code],
		sub.[Name] AS [Subject Name],
		maj.[Name] AS [Major Name],
		(src.Mark*src.WeightedMark) AS [Total Mark],
		per.EndDate AS [End Period Date]
	FROM dbo.Student AS stu
		JOIN dbo.StudentMajor AS sm ON stu.StudentNumber=sm.StudentNumber
		JOIN dbo.Major AS maj ON sm.MajorID=maj.ID
		JOIN dbo.[Subject] AS sub ON maj.ID=sub.MajorID
		JOIN dbo.Enrollment AS enr ON stu.StudentNumber=enr.StudentNumber
		JOIN dbo.StudentSubject AS sts ON enr.ID=sts.EnrollmentID
		JOIN dbo.StudentReportCard AS src ON sts.ID=src.StudentSubjectID
		JOIN dbo.[Period] AS per ON enr.PeriodID=per.ID
	WHERE stu.StudentNumber = @StudentNumber;
END

EXECUTE dbo.StudyTranscript @StudentNumber = '2012/03/0001';

SELECT * FROM Student