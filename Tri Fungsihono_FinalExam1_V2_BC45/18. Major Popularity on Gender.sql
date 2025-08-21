USE Unicorn;

SELECT pvt.[Major Name], [Male],[FEMALE]
FROM(
	SELECT 
		maj.[Name] AS [Major Name],
		(CASE WHEN stu.Gender = 'M'
				THEN 'Male'
			WHEN stu.Gender = 'F'
				THEN 'FEMALE'
			ELSE ''
			END) AS Gender
	FROM dbo.Student AS stu
		JOIN dbo.StudentMajor AS sm ON stu.StudentNumber=sm.StudentNumber
		RIGHT JOIN dbo.Major AS maj ON sm.MajorID=maj.ID
) AS tbl PIVOT(
	COUNT(tbl.Gender) FOR tbl.Gender IN ([Male],[FEMALE])
) AS pvt;