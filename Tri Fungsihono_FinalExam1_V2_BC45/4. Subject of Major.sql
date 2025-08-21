USE Unicorn;

CREATE TYPE MajorName AS TABLE(
	[Major] VARCHAR(200)
);
GO
CREATE OR ALTER PROCEDURE dbo.SubjectofMajor
	@MajorList AS dbo.MajorName READONLY
AS
BEGIN
	SELECT 
		DISTINCT maj.[Name] AS [Major Name],
		(CASE WHEN maj.[Description] IS NULL
			THEN 'Ask student call center for this subject 
				informationAsk student call center for this subject 
				information'
		ELSE maj.[Description]
		END) AS Deskripsi,
		(CASE WHEN maj.[Level] = 'B'
			THEN 'Bachelor'
		WHEN maj.[Level] = 'M'
			THEN 'Master'
		WHEN maj.[Level] = 'P'
			THEN 'Phd'
		ELSE '' 
		END) AS [Level],
		sub.Cost
	FROM dbo.Major AS maj
		JOIN dbo.[Subject] AS sub ON maj.ID=sub.MajorID
	WHERE EXISTS (SELECT 1 FROM @MajorList WHERE maj.[Name] LIKE '%'+[Major]+'%');
END;
GO
DECLARE @Major AS dbo.MajorName
INSERT INTO @Major ([Major]) VALUES ('data');
EXECUTE dbo.SubjectofMajor @MajorList = @Major;