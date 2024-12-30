CREATE TABLE IF NOT EXISTS public."Student" (
    ID INT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Marks INT CHECK (Marks >= 0)
);
