**User Document for CS3365 Team Project - Small Business Database Software**

**Team Members:** Connor Irvine, Robert Kirkman, Lora Milam

**Github Link:** https://github.com/robertkirkman/business-database-cs3365

**Goal:** Fulfil the order record-keeping and client information needs of a small business using a straightforward database.

**Potential Users:** Any small office or business, local governments, non-profit organizations, simulation and academic purposes, open source community developers.

**Architecture Diagram:**
![Architecture Diagram](https://raw.githubusercontent.com/robertkirkman/business-database-cs3365/master/ArchitectureDiagram2.png)

**Class Diagram:**
![Class Diagram](https://raw.githubusercontent.com/robertkirkman/business-database-cs3365/master/Class%20Diagram.png)

**State Diagrams:**

**CurrentTableObj State Diagram:**
![CurrentTableObj State Diagram](https://raw.githubusercontent.com/robertkirkman/business-database-cs3365/master/CurrentTableObjStateDiagram2.png)
**CustomerTableObj State Diagram:**
![CustomerTableObj State Diagram](https://raw.githubusercontent.com/robertkirkman/business-database-cs3365/master/CustomerTableObjStateDiagram.png)
**EmployeeTableObj State Diagram:**
![EmployeeTableObj State Diagram](https://raw.githubusercontent.com/robertkirkman/business-database-cs3365/master/EmployeeTableObjStateDiagram.png)
**OrderTableObj State Diagram:**
![OrderTableObj State Diagram](https://raw.githubusercontent.com/robertkirkman/business-database-cs3365/master/OrderTableObjStateDiagram.png)

**Sequence Diagrams:**

**Query Sequence Diagram:**
![Query Sequence Diagram](https://raw.githubusercontent.com/robertkirkman/business-database-cs3365/master/QuerySequenceDiagram.png)
**Modify Sequence Diagram:**
![Modify Sequence Diagram](https://raw.githubusercontent.com/robertkirkman/business-database-cs3365/master/ModifySequenceDiagram.png)
**Export Sequence Diagram:**
![Export Sequence Diagram](https://raw.githubusercontent.com/robertkirkman/business-database-cs3365/master/ExportSequenceDiagram.png)
**Change Current Working Table Sequence Diagram:**
![Change Current Working Table Sequence Diagram](https://raw.githubusercontent.com/robertkirkman/business-database-cs3365/master/ChangeTableSequenceDiagram.png)

**Use Cases:**

**Use Case Diagrams:**
![Use Case Diagram Level 0](https://raw.githubusercontent.com/robertkirkman/business-database-cs3365/master/UseCaseDiagramLvl0.png)
![Use Case Diagram Level 1](https://raw.githubusercontent.com/robertkirkman/business-database-cs3365/master/UseCaseDiagramLvl1.png)

**Use Case Name:** Query Field

**Use Case Description:** Retrieve information from a specified cell in the current working table and display the contained information for the client. 

**System:** Small Business Database

**Actors:** Client

**Stimulus:** The client has decided on a field and row (row and column) to retrieve, and has typed the command to query that field with the correct parameters. 

**Response:** The desired information has been retrieved from the database and successfully displayed for the client. 

**Normal Flow:**
1. The client types desired information in the query command using the correct syntax.
   a. An error message will return if the syntax is incorrect
2. The system uses the provided information to search the current working table(s) for the desired data.
3. Either the system identifies matching data and displays it to the client, or a null return message will appear


**Use Case Name:** Modify Field

**Use Case Description:** Change information in or delete information from a specified cell in the current working table.

**System:** Small Business Database

**Actors:** Client

**Stimulus:** The client has decided to change or delete the information contained in a specific cell in the current working table, and has the field, row, and information for the cell, if applicable.

**Response:** The information in the cell is modified to reflect the desired changes.

**Normal Flow:**
1. The client has decided to change or delete information contained in a specific cell that they have permission to modify.
2. The client either types the field, row and data to modify in conjunction with the modify command, or the delete command in conjunction with the field and row to delete, using the correct syntax.
3. The system uses the provided information to search the current working table for the desired cell.
4. Either the system identifies the desired cell and modifies or deletes its content as specified, or the syntax or parameters are incorrect and a descriptive error message is displayed.

**Use Case Name:** Export CSV

**Use Case Description:** Create a comma-separated values (CSV) file containing all the data listed in the current working table and present the file to the client.

**System:** Small Business Database

**Actors:** Client

**Stimulus:** The client wants to back up all the data from the current working table into a different application or a universal format, here facilitated by a comma-separated values plaintext file.

**Response:** All values in all fields in the current working table are formatted into a plaintext ascii comma-separated values file and this file is presented to the client for storage or use outside of the system.

**Normal Flow:**
1. The client types the export command correctly.
2. The system retrieves all the data from the current working table and formats it into a CSV file.
3. The system presents the CSV file to the client in a plaintext format.

**Use Case Name:** Change Current Working Table

**Use Case Description:** Change the current table to either the Orders table, the Customers table, or the Employees table.

**System:** Small Business Database

**Actors:** Client

**Stimulus:** The client wants to query or modify fields in a table that is not currently selected.

**Response:** The current working table is updated to reflect the desired change.

**Normal Flow:**
1. The client decides which table they want to query or modify.
2. The client types that table’s parameter in conjunction with the change working table command using the correct syntax.
3. The system matches the provided information to the desired table name.
4. The system switches the client’s current working table to the specified selection.

**Contributions:**

**Use Case Diagrams:** Connor Irvine & Robert Kirkman

**Use Case Specifications:** Robert Kirkman, Lora Milam & Connor Irvine

**Architecture Diagram:** Robert Kirkman

**Class Diagram:** Connor Irvine, Robert Kirkman & Lora Milam

**Sequence Diagrams:** Robert Kirkman

**State Diagrams:** Robert Kirkman

**Activity Diagram:** Connor Irvine
