# Nyani User Guide

```
     ^,,,,^
     ( O-O)
     /^   >
Hi there! I'm NYANI ^_^
What shall we do today?
Type 'help' to see all commands :)
Nyani doesn't have any files to read at the moment...
```
Nyani is here to make organising tasks much easier!

## Notes about command format

- Words in `UPPERCASE` are parameters to be given by the user.
  eg. `todo TASK`, `TASK` is a parameter which can be used as `todo do homework`.
  
- Commands are not case-sensitive.
  eg. `Todo`, `todo` and `TODO` all work the same.

## Viewing a list of commands `help`

Shows a list of commands the user can input.

Example: `help`

```
List of commands:
────────────────────
list: shows todo list
mark: marks item as done
unmark: unmarks item as done
deadline: adds an item with specified deadline
          try deadline [task] /by [date/time]!
event: creates an event with specified timeline
       try event /from [date/time] /to [date/time]!
find: finds the task with your specified keyword
Type <bye> to exit & save your list!
────────────────────
```

## Viewing task list `list`

Allows user to view the list of tasks added.

Example: `list`
```
────────────────────
To-do!
1. [T][ ] do homework
2. [D][ ] do homework (by: 5pm)
3. [E][ ] CS2113 class (from: 5pm to: 6pm)
────────────────────
```

## Marking tasks as done `mark`

Marks task as done with a 'X'.

Format: `mark TASK_NUMBER`

Example: `mark 1`

```
Marked > do homework < as done!
```

`list`

```
────────────────────
To-do!
1. [T][X] do homework
2. [D][ ] do homework (by: 5pm)
3. [E][ ] CS2113 class (from: 5pm to: 6pm)
────────────────────
```

## Unmarking tasks as done `unmark`

Unmarks task as done, removing the 'X' symbol.

Format: `unmark TASK_NUMBER`

Example: `unmark 1`

```
Unmarked > do homework < as done!
```

`list`

```
────────────────────
To-do!
1. [T][ ] do homework
2. [D][ ] do homework (by: 5pm)
3. [E][ ] CS2113 class (from: 5pm to: 6pm)
────────────────────
```

## Adding normal tasks `todo`

Adds general tasks without a time-sensitive window.

Format: `todo TASK_DESCRIPTION`

Example: `todo do homework`

```
Added > [T][ ] do homework < !
```

## Adding deadlines `deadline`

Adds deadlines to your task!

Format: `deadline TASK_DESCRIPTION /by TIME`

Example: `deadline do homework /by 5pm`

```
Added > [D][ ] do homework (by: 5pm) < !
```

## Adding events `event`

Adds a user specified time window task.

Format: `event TASK_DESCRIPTION /from TIME /to TIME`

Example: `event CS2113 class /from 5pm /to 6pm`

```
Added > [E][ ] CS2113 class (from: 5pm to: 6pm) < !
```

## Finding tasks `find`

Finds the task(s) containing the user-specified keyword.

Format: `find KEYWORD`

Example: `find homework`

```
[T][ ] do homework
[D][ ] do homework (by: 5pm)
```

## Saving tasks `bye`

Exits the app, and saves the list.
Remember to save the list by inputting `bye`, else it will not save!

Example: `bye`

```
Nyani will remember ur tasks for u!
Loading tasks...
[ ]TODO: do homework
[ ]DEADLINE (by: 5pm) | do homework
[ ]EVENT (from: 5pm to: 6pm) | CS2113 class
────────────────────
c U soon! :D 
────────────────────
```

## Additional Notes

Should any unrecognised input be detected, user will be prompted to re-enter a recognisable input.

Example: `hi`

```
────────────────────
Nyani doesn't understand hi!
Enter 'help' for available commands :)
────────────────────
```


