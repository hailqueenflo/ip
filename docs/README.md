# User Guide
Duke is a personal task-tracking assistant that operates based on user inputs.
It is able to track Todo, Deadline and Event tasks.
Tasks can be marked as done or deleted.
Relevant tasks can also be returned with a search function.

Refer to [this guide](https://github.com/hailqueenflo/ip/blob/master/README.md#setting-up-in-intellij) for instructions on how to set up the project in Intellij.

## Start the Program
1. Open Command Prompt (CP) by pressing Windows key + R.
Enter "cmd" in the Prompt.
2. Copy the path of the Jar file.
3. Input `java -jar c:pathtojarfile.jar` in the CP and Enter.
Replace `c:pathtojarfile.jar` with the actual path and file title of the Jar file.

## Features

### Add `todo`
Adds a Todo to the task list. A description of the task is required.

### Add `deadline`
Adds a Deadline to the task list. A description and date/time is required.

### Add `event`
Adds an event to the task list. A description and date/time is required.

### `delete` task
Removes a task from the task list, given index from user input.

### Mark task as `done`
Marks a task from the task list as done, given index from user input.

### `find` tasks
Searches all tasks in the list given user search term.
Returns all relevant tasks with search term.

### `list` tasks
Displays the whole list of tasks with the index and description.

### Exit program
Exits Duke.

### Save data
Saves data into the hard disk automatically after any user command modifies the task list.

### Date formatter
Formats date.

## Usage

| __Note about the command format:__                                                                                             |
|--------------------------------------------------------------------------------------------------------------------------------------------------------|
| Words in `UPPER_CASE` are the parameters to be supplied by the user.  e.g. in `todo TASK`, `TASK` is a parameter which can be used as `todo read book` |

### `todo` - Adds a Todo task
Adds a Todo to the task list.

Format: `todo TASK`

Example of usage: `todo read book`

### `deadline` - Adds a Deadline task
Adds a Deadline to the task list.

Format: `deadline TASK /by: DATE_TIME`

Example of usage:

- `deadline Math assignment /by: today`
- `deadline return book /by: 2020-11-05`

### `event` - Adds an Event task
Adds an Event to the task list.

Format: `event TASK /at: DATE_TIME`

Example of usage:
- `event meeting /at: 5pm`
- `event class /at: 2020-12-12`

| `deadline` and `event` can return `DATE_TIME` as `LocalDate` if `DATE_TIME` is in the format `yyyy-mm-dd`. |
|:----------------------------------------------------------------------------------------------------------:|

### `delete` - Deletes a task
Deletes a task from the task list.

Format: `delete TASK_INDEX`

Example of usage: `delete 3`

Expected outcome:

```javascript
    ____________________________________________________________
      Noted. I’ve removed this task: 
      [E][✘] movie (at: Oct 11 2020)
      Now you have 3 tasks in the list.
     ____________________________________________________________
```

### `done` - Mark tasks as done
Marks a task from the task list as done.

Format: `done TASK_INDEX`

Example of usage: `done 4`

Expected outcome:

```javascript
    ____________________________________________________________
     Nice! I’ve marked this task as done:
       [E][✓] lunch (at: 12pm)
    ____________________________________________________________
```

### `find` - Find relevant tasks
Finds all tasks that contains user's search item, and prints a list.

Format: `find SEARCH_TERM`

Example of usage: `find book`

Expected outcome:

```javascript
    ____________________________________________________________
     Here are the matching tasks in your list:
     1. [T][✘] read book A
     2. [D][✘] return book B (by: today)
     3. [E][✘] book signing (at: Oct 11 2020)
    ____________________________________________________________
```

### `list` - Prints list
Prints list of all tasks.

Example of usage: `list`

Expected outcome:

```javascript
    ____________________________________________________________
1. [T][✘] read
2. [E][✓] lunch (at: 12pm)
3. [T][✘] read book A
4. [D][✘] return book B (by: today)
5. [E][✘] book signing (at: Oct 11 2020)
    ____________________________________________________________
```

### `bye` - Exits application
Exits Duke and prints a goodbye message.

Example of usage: `bye`

Expected outcome:

```javascript
    ____________________________________________________________
     Bye. Hope to see you again soon!
    ____________________________________________________________
```

## FAQ
__Q__: How do I transfer my data to another Computer?

__A__: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous Duke home folder.

## Command summary

|  __Action__  |                            __Format, Examples__                            |
|------------- | -------------------------------------------------------------------------- |
|   __Todo__   | `todo TASK` e.g., `todo read book`                                        |
| __Deadline__ | `deadline TASK /by: DATE_TIME` e.g., `deadline assignment /by: 2020-10-11` |
|   __Event__  | `event TASK /at: DATE_TIME` e.g., `event meeting /at: 2pm`                 |
|  __Delete__  | `delete TASK_INDEX` e.g., `delete 4`                                       |
|   __Done__   | `done TASK_INDEX` e.g., `done 3`                                           |
|   __Find__   | `find SEARCH_ITEM` e.g., `find book`                                       |
|    __Bye__   | `bye`                                                                      |
|   __List__   | `list`                                                                     |
