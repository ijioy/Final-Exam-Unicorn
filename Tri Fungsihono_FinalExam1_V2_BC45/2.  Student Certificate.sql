USE Unicorn;

SELECT 
	CONCAT_WS(' ',stu.FirstName,stu.MiddleName,stu.LastName) AS [Nama Lengkap],
	CONCAT(cit.[Name],', ',
			(CONCAT_WS(' ',DATENAME(DAY,stu.BirthDate),
			DATENAME(MONTH,stu.BirthDate),
			DATENAME(YEAR,stu.BirthDate)))) AS [Kelahiran],
	(CASE WHEN cer.[Level] = 'B'
			THEN 'Bachelor'
		WHEN cer.[Level] = 'M'
			THEN 'Master'
		WHEN cer.[Level] = 'P'
			THEN 'Phd'
		ELSE '' 
		END) AS [Level],
	cer.AcademicTitle AS [Academic Title],
	(CASE WHEN cer.Grade = 'PAS'
			THEN 'Pass'
		WHEN cer.Grade = 'CRE'
			THEN 'Credit'
		WHEN cer.Grade = 'DIS'
			THEN 'Distinction'
		ELSE 'High Distinction' 
		END) AS Grade,
	cer.GraduateDate AS [Graduate Date]
FROM dbo.Student AS stu
	JOIN dbo.city AS cit ON stu.BirthCityID=cit.ID
	JOIN dbo.[Certificate] AS cer ON stu.StudentNumber=cer.StudentNumber;