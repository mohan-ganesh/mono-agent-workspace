
import { Component, OnInit } from '@angular/core';
import { ChatService } from '../services/chat-service.service';
import { ElementRef, ViewChild, AfterViewChecked } from '@angular/core';
import { DomSanitizer, SafeHtml } from '@angular/platform-browser';
import { CustomMarkupPipe } from '../directives/CustomMarkupPipe';
import { SessionStorageServiceService } from "../services/session-storage-service.service"

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})
export class ChatComponent implements OnInit, AfterViewChecked {



  @ViewChild('chatContainer') private chatContainer?: ElementRef;

  queryId: string | undefined;
  messages: any[] = [];
  newMessage: string = ''; // Property to bind with the input
  loading: boolean = false;
  userInteracted: boolean = false;


  constructor(private ChatService: ChatService, private sanitizer: DomSanitizer, private sessionStorageService: SessionStorageServiceService) { }

  sanitizeHtml(html: string): SafeHtml {
    return this.sanitizer.bypassSecurityTrustHtml(html);
  }

  ngAfterViewChecked(): void {
    //console.log(this.chatContainer);
    //console.log(this.chatContainer?.nativeElement);
    try {
      if (this.chatContainer) {
        //console.log('try to scroll');
        //this.chatContainer.nativeElement.scrollTop = this.chatContainer.nativeElement.scrollHeight;
        const scrollContainer = this.chatContainer.nativeElement;
        scrollContainer.scrollTop = scrollContainer.scrollHeight;
        scrollContainer.scrollIntoView({ behavior: 'smooth', block: 'end', inline: 'nearest' });

      }
    } catch (error) {
      console.log(error);
    }
  }

  ngOnInit(): void {
    // Assuming you have a reference to the chat container element
    //console.log('im-onInit' + document.querySelector('.chat-container'))
    //this.chatContainer = document.querySelector('.chat-container');
    //console.log("reference of " + this.chatContainer);
  }


  newChat() {
    this.messages = [];
    this.queryId = undefined;
    this.sessionStorageService.setValue("queryId", "");
  }


  sendMessage(message: string) {
    const trimmedMessage = message.trim();
    if (!trimmedMessage) return; // Prevent sending empty messages

    this.messages.push({ content: trimmedMessage, isUser: true });
    this.newMessage = ''; // Clear the input

    // Set loading to true after 5 seconds
    setTimeout(() => {
      this.loading = true;
    }, 2000);

    this.ChatService.sendMessage(trimmedMessage).subscribe(response => {
      this.loading = false;


      if (response) {
        const currentdate = new Date();
        const formattedDate = currentdate.toLocaleString();
        let result = response.answer + "<i> [Generated at " + formattedDate + "].</i>";

        this.queryId = response.queryId;

        const tempId = response.queryId;
        if (tempId != undefined || tempId != null) {
          console.log('set the query id ' + tempId);
          this.sessionStorageService.setValue("queryId", tempId);
        }

        this.messages.push({ content: result, isUser: false });
      }


    }, (error) => {
      console.log("error occured", error);
      this.loading = false;
    });

  }

  scrollToBottom() {

    let chatContainer = document.querySelector('.chat-container');
  }
}
