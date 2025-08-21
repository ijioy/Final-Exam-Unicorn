USE Unicorn;

SELECT 
	CONCAT_WS(' ',stu.FirstName,stu.MiddleName,stu.LastName) AS [Nama Lengkap],
	CONCAT(cit.[Name],', ',
	(CONCAT_WS(' ',DATENAME(DAY,stu.BirthDate),
			DATENAME(MONTH,stu.BirthDate),
			DATENAME(YEAR,stu.BirthDate)))) AS [Kelahiran],
	maj.[Name] AS [Major Name]
FROM dbo.Student AS stu
	JOIN dbo.city AS cit ON stu.BirthCityID=cit.ID
	JOIN dbo.StudentMajor AS sm ON stu.StudentNumber=sm.StudentNumber
	JOIN dbo.Major AS maj ON sm.MajorID=maj.ID
	LEFT JOIN dbo.[Certificate] AS cer ON stu.StudentNumber=cer.StudentNumber
WHERE cer.StudentNumber IS NULL;