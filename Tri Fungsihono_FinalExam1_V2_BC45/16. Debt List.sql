USE Unicorn;

SELECT 
	stu.StudentNumber AS [StudentNumber],
	CONCAT_WS(' ',stu.FirstName, stu.MiddleName, stu.LastName) AS [Student Full Name],
	SUM(sub.Cost) AS [Total Debt (Total Hutang)]
FROM dbo.Student AS stu
	JOIN dbo.Enrollment AS enr ON stu.StudentNumber=enr.StudentNumber
	JOIN dbo.StudentMajor AS sm ON stu.StudentNumber=sm.StudentNumber
	JOIN dbo.Major AS maj ON sm.MajorID=maj.ID
	JOIN dbo.[Subject] AS sub ON maj.ID=sub.MajorID
WHERE enr.[Status] = 'PEN'
GROUP BY stu.StudentNumber,
	CONCAT_WS(' ',stu.FirstName, stu.MiddleName, stu.LastName);