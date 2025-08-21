USE Unicorn;

SELECT
    sub.Code AS [Subject Code],
    sub.[Name] AS [Subject Name],
    sub.Cost AS [Current Price], 
    enr.TransactionDate AS [Transaction Date],
    enr.Fee AS [Price on Transaction], 
    (sub.Cost - enr.Fee) AS [Selisih Harga]
FROM dbo.Student AS stu
	JOIN dbo.Enrollment AS enr ON stu.StudentNumber=enr.StudentNumber
	JOIN dbo.StudentMajor AS sm ON stu.StudentNumber=sm.StudentNumber
	JOIN dbo.Major AS maj ON sm.MajorID=maj.ID
	JOIN dbo.[Subject] AS sub ON maj.ID=sub.MajorID
WHERE sub.Cost <> enr.Fee -- Hanya menamp harganya berubah
ORDER BY
    enr.TransactionDate ASC;