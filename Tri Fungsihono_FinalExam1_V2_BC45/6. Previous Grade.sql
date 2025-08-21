USE Unicorn;

SELECT   
	TRIM(edh.Institution) AS Institusi,
	AVG(edh.Grade) AS [Nilai Rata-rata Berdasarkan Institusi]
FROM dbo.EducationHistory AS edh
	JOIN dbo.Student AS stu ON stu.StudentNumber=edh.StudentNumber
GROUP BY edh.Institution
ORDER BY Institusi;