# Preview all emails at http://localhost:3000/rails/mailers/upload_mailer
class UploadMailerPreview < ActionMailer::Preview
# Set up a temporary order for the preview
def new_upload_mail_preview
    UploadMailer.new_upload_email(User.first)
  end

end
