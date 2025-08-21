USE Unicorn;

SELECT
    maj.Name AS [Major Name],
    (CASE WHEN maj.Level = 'B' 
			THEN 'Bachelor'
        WHEN maj.Level = 'M' 
			THEN 'Master'
        WHEN maj.Level = 'P' 
			THEN 'Phd'
        ELSE ''
    END) AS [Major Level],
    sub.Name AS [Subject Name],
    (CASE WHEN sub.Level = 'B' 
			THEN 'Bachelor'
        WHEN sub.Level = 'M' 
			THEN 'Master'
        WHEN sub.Level = 'P' 
			THEN 'Phd'
        ELSE ''
    END) AS [Subject Level]
FROM dbo.Major AS maj
	JOIN dbo.Subject AS sub ON maj.ID = sub.MajorID
WHERE sub.NonActiveDate IS NULL AND maj.Level <> sub.Level
ORDER BY maj.Name, sub.Name;