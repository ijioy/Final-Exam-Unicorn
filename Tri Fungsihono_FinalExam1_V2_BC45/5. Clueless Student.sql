USE Unicorn;

SELECT 
	CONCAT_WS(' ',stu.FirstName, stu.MiddleName, stu.LastName) AS Fullname,
	CONCAT_WS(', ', stu.[Address], cit.[Name], sta.[Name], cou.[Name]) AS [Alamat Lengkap]
FROM dbo.Student AS stu
	JOIN dbo.City AS cit ON stu.CitizenshipID=cit.ID
	JOIN dbo.[State] AS sta ON cit.StateID=sta.ID
	JOIN dbo.Country AS cou ON sta.CountryID=cou.ID
	JOIN dbo.Enrollment AS enr ON stu.StudentNumber=enr.StudentNumber
WHERE enr.TransactionDate IS NULL
GROUP BY CONCAT_WS(' ',stu.FirstName, stu.MiddleName, stu.LastName),
	CONCAT_WS(', ', stu.[Address], cit.[Name], sta.[Name], cou.[Name]);