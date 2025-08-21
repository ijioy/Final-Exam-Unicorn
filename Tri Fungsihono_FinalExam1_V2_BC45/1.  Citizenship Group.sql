USE Unicorn;

SELECT 
	cou.[Name] AS [Negara Asal],
	COUNT(CitizenshipID) AS [Jumlah Mahasiswa]
FROM dbo.Country AS cou
	JOIN dbo.Student AS stu 
		ON cou.ID=stu.CitizenshipID
GROUP BY cou.[Name];