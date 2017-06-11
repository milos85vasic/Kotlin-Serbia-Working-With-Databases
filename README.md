# Kotlin Serbia - Dealing with Databases
Code examples for Kotlin Serbia meetup.

# Highlights
CRUD highlights:

- Insert:
```
val students = mutableListOf<Student>()
students.add(Student("Mihajlo", "Pupin", 1858))
students.add(Student("Milutin", "Milanković", 1879))
students.add(Student("Nikola", "Tesla", 1856))

val success = Db.insert(students)
```
or:
```
val student0 = Student("Mihajlo", "Pupin", 1858)
val student1 = Student("Milutin", "Milanković", 1879)
val student2 = Student("Nikola", "Tesla", 1856)

val success = Db.insert(student0, student1, student2)
```

- Update:
```
student0.firstName = "CHANGED"
student1.lastName = "CHANGED"

// UPDATE:
val success =  Db.update(student0, student1)
```

- Delete:
```
val success = Db.delete(students)
```
or
```
val success = Db.delete(student0, student1)
```

- Select:
```
val students = Db.select(Pair(DbHelper.FIRST_NAME, "Nikola"))
```

- Select all:
```
val students = Db.select()
```
