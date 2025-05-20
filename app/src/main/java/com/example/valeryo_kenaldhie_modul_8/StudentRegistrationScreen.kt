import androidx.compose.runtime.Composable

@Composable
fun StudentRegistrationScreen(viewModel: StudentViewModel =
                                  viewModel()) {
    var studentId by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var program by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxSize()) {

        TextField(value = studentId, onValueChange = { studentId = it },
            label = { Text("Student ID") })
        TextField(value = name, onValueChange = { name = it }, label = {
            Text("Name") })
        TextField(value = program, onValueChange = { program = it },
            label = { Text("Program") })

        Button(
            onClick = {
                viewModel.addStudent(Student(studentId, name, program))
                studentId = ""
                name = ""
                program = ""
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Submit")
        }

        Divider(modifier = Modifier.padding(vertical = 16.dp))

        Text("Student List", style =
            MaterialTheme.typography.titleMedium)

        LazyColumn {
            items(viewModel.students) { student ->
                Text("${student.id} - ${student.name} -
                    ${student.program}")
            }
        }
    }
}