**User ****Document for CS3365 Team Project - Small Business Database Software**
**Team Members:** Connor Irvine, Robert Kirkman, Lora Milam
**Github Link:** https://github.com/robertkirkman/business-database-cs3365
**Goal:** Fulfil the order record-keeping and client information needs of a small business using a straightforward relational database.
**Potential ****Users****:** Any small office or business, local governments, non-profit organizations, simulation and academic purposes, open source community developers.

**Use Cases:**
**Use Case Name: **Query Field
**Use Case Description: **Retrieve information from a specified cell in the current working table and display the contained information for the client. 
**System: **Small Business Database
**Actors: **Client
**Stimulus: **The client has decided on a field and row (row and column) to retrieve, and has typed the command to query that field with the correct parameters. 
**Response: **The desired information has been retrieved from the database and successfully displayed for the client. 
**Normal Flow:**
1. The client decides a field and row to specify which cell to query.
2. The client types those parameters in conjunction with the query command using the correct syntax. 
3. The system uses the provided information to search the current working table for the desired data.
4. Either the system identifies matching data and displays it to the client, or the syntax or provided information is incorrect and a descriptive error message is displayed.

**Use Case Name: **Modify Field
**Use Case Description: **Change information in or delete information from a specified cell in the current working table.
**System: **Small Business Database
**Split Use Case:**
* **Unrestricted Entries****:**
 * **Actors:** Client
 * **Stimulus:** The client has decided to change or delete the information contained in a specific cell in the current working table that does not have restricted editing permissions, and has the field, row, and information for the cell, if applicable. 
* **Restricted Entries: **
 * **Actors:** Administrator
 * **Stimulus:** The administrator has decided to change or delete the information contained in a restricted cell in the current working table that only the administrator has editing permissions for, and has the field, row, and information for the cell, if applicable. 
**Response: **The information in the cell is modified to reflect the desired changes.
**Normal Flow:**
1. The client or administrator has decided to change or delete information contained in a specific cell that they have permission to modify.
2. The client or administrator either types the field, row and data to modify in conjunction with the modify command, or the delete command in conjunction with the field and row to delete, using the correct syntax.
3. The system uses the provided information to search the current working table for the desired cell.
4. Either the system identifies the desired cell and modifies or deletes its content as specified, or the syntax or parameters are incorrect and a descriptive error message is displayed.

**Use Case Name:** Export CSV
**Use Case Description:** Create a comma-separated values (CSV) file containing all the data listed in the current working table and present the file to the client.
**System: **Small Business Database
**Actors: **Client
**Stimulus:** The client wants to back up all the data from the current working table into a different application or a universal format, here facilitated by a comma-separated values plaintext file.
**Response: **All values in all fields in the current working table are formatted into a plaintext ascii comma-separated values file and this file is presented to the client for storage or use outside of the system.
**Normal Flow:**
1. The client types the export command correctly.
2. The system retrieves all the data from the current working table and formats it into a CSV file.
3. The system presents the CSV file to the client in a plaintext format.

**Use Case Name:** Change Current Working Table
**Use Case Description:** Change the current table to either the Orders table or the Client Customers table, the two tables that will be implemented.
**System:** Small Business Database
**Actors:** Client
**Stimulus: **The client wants to query or modify fields in a table that is not currently selected.
**Response:** The current working table is updated to reflect the desired change.
**Normal Flow:**
1. The client decides which table they want to query or modify.
2. The client types that table’s parameter in conjunction with the change working table command using the correct syntax.
3. The system matches the provided information to the desired table name.
4. The system switches the client’s current working table to the specified selection.
**Contribution:**
Robert Kirkman: Modify Field Use Case
Connor Irvine: 
Lora Milam: Export Use Case
