class UploadMailer < ApplicationMailer
     
    def new_upload_email(user,file)
        @user = user
        attachments[file.original_filename] = file.read
        mail(to: "noreply@laudeitelemedicina.com.br",from: @user.email, subject: 'Sample Email')
      end

      
end
