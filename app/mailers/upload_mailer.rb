class UploadMailer < ApplicationMailer
     
    def new_upload_email(user,file)
        @user = user
        attachments[file.original_filename] = file.read
        mail(to: "exames@laudeitelemedicina.com.br",from: @user.email, subject: file.original_filename)
      end

      
end
